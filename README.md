# keycloak-group-password-policy
This keycloak extension (currenty developed and tested against versions 6, 8-15, 18, 26) aims to
create the possibility to assign additional password rules to user groups, extending the
rules attached to the realm, _not_ replacing them.

The extension registers a class implementing org.keycloak.policy.PasswordPolicyProviderFactory.
It is available as a new type of password policy on the realm's password policy sub-page.

## Installation
The extension can be installed just like any keycloak extension. Either copy it to the
`keycloak/standalone/deployments` folder for JBoss deployments or in `keycloak/deployments` 
for quarkus distributions, or load it via the jboss command line tool.

## Usage
There are multiple steps you will want to take to use this plugin.  First, you need to determine
what password policies you will want for all users and for each group of users.  Once you have
that, you will need to come up with an ID where you will specify group password policies.  For
the purposes of this documentation we will use the ID `passwordPolicy`.

Go to the realm's password policy page.  In the latest versions of Keycloak, this can be found
by navigating to the "Authentication" menu item in the vertical menu on the left side of the
realm's user interface.  You will then need to navigate to the "Password Policy" tab along the
menu of tabs on the top of the page.

This interface provides you the OOTB ability to specify password policies for **all** users.
This is still true with the plugin installed.  You will now have an additional option: **Group
Policy**.  To use the plugin, you must add that password policy.  The "Policy Value" should be
set to the ID we came up with earlier: `passwordPolicy`.

If you intend to use group-specific password expiration (`forceExpiredPasswordChange`), you will
need to perform an additional step in the configuration.  In the same "Authentication" section,
navigate to the "Required Actions" tab along the menu of tabs on the top of the page.  Use the
"Register" button to add the "Group-based Expired Password" action.  Move it up in the order to
after the "Update Password" action.

At this point, you will need to add an attribute (with key `passwordPolicy`) to each group you
want to have additional password policies.  The format of that text is defined by Keycloak
documentation and covered in the section below.

### Password policy format
All policies are represented by a short string immediately followed by parenthesis, optionally
containing configuration data. All policies are then concatenated using the fixed string `" and "`.

For example:

[`length(8) and digits(2) and lowerCase(2) and upperCase(2) and specialChars(2) and notUsername()`](https://github.com/keycloak/keycloak/blob/6.0.1/testsuite/integration-arquillian/tests/base/src/test/java/org/keycloak/testsuite/policy/PasswordPolicyTest.java#L243)

The [policies provided with KeyCloak](https://www.keycloak.org/docs/latest/server_admin/#authentication-operations) are:

| Identifier    | Parameter description                | Tested |
| ------------- |:------------------------------------ | ------ |
| `length(int)` | minimum number of unicode characters | ✓ |
| `digits(int)` | minimum number of digits             | ✓ |
| `lowerCase(int)` | minimum number of lower case unicode characters | ✓ |
| `upperCase(int)` | minimum number of upper case unicode characters | ✓ |
| `specialChars(int)` | minumum number of special characters | ✓ |
| `regexPattern(string)` | regular expression | ✓ |
| `notUsername()` |  | ✓ |
| `passwordBlacklist(string)` | file name | - |
| `passwordHistory(int)` | number of last used passwords to disallow | ✓ |
| `forceExpiredPasswordChange(string)` | number of days to expire password after | ✓ |

On the realm model the password policy attribute is also used for other purposes.
There are some registered "policies", that do not actually implement a policy that
a password is checked against, but when it has to be changed and how it is stored.

If these currently work is completely untested.

| Identifier    | Description                          | Tested |
| ------------- |:------------------------------------ | ------ |
| `hashAlgorithm(string)` | hash algorithm to use when hashing the password | - |
| `hashIterations(int)` | number of hash iterations | - |

## Implementation
To minimize code duplication the extension uses as much of the built-in KeyCloak code
as possible. The parsing and instantiation of the policy provider classes is used as-is.

As all policies are configured via the RealmModel, a custom implementation of the RealmModel
interface (`FakeRealm`) is used to inject the configuration into the classes.

For details please have a look at the source code.

### Building

The build must match your version of Keycloak.  There is no good backward compatibility due to
changing signatures.  So select a version range from the table below.  These ranges are copied
from the profiles in the `pom.xml`.

| Minimum Version | Maximum Version | Profile          |
|:---------------:|:---------------:| ---------------- |
| 6.x             | 6.x             | keycloak-v6      |
| 7.x             | 7.x             | keycloak-v7      |
| 8.x             | 11.x            | keycloak-v8-v11  |
| 12.x            | 12.x            | keycloak-v12     |
| 13.x            | 14.x            | keycloak-v13-v14 |
| 15.x            | 24.x            | keycloak-v15-v24 |
| 25.x            | 26.x            | keycloak-v25-v26 |

Here is an example build:
```bash
mvn -Pkeycloak-v15-v24 clean package
```

This will create a file in the following format: `keycloak-group-password-policy-{version}-keycloak-v15-v24.jar`.

This file will work in Keycloak versions v15 through v24, inclusive.  It will fail on earlier
and later versions.

If you want to try to build this against a version that did not yet exist at the time of this
writing, it *may* work.  If it does, please update the project by changing all the related
version numbers and folder names.
