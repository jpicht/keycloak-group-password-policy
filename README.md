# keycloak-group-password-policy
This keycloak extension (currenty developed and tested against version 6.0.1) aims to
create the possibility to assign additional password rules to user groups, extending the
rules attached to the realm, _not_ replacing them.

The extension registers a class implementing org.keycloak.policy.PasswordPolicyProviderFactory.
It is available as a new type of password policy on the realm's password policy sub-page.

## Installation
The extension can be installed just like any keycloak extension. Either copy it to the
`keycloak/standalone/deployments` folder, or load it via the jboss command line tool.

## Usage
To use the plugin you create a new password policy entry on the realm's password policy sub-page
with the `Group Policy` type, then enter a group attribute name as the configuration.
On a password change request, the extension will then check all the user's groups for this
attribute name and parse the corresponding attribute value as a serialized password policy.

### Password policy format
All policies are represented by a short string immediately followed by parenthesis, optionally
containing configuration data. All policies are then concatenated using the fixed string `" and "`.

For example:

[`length(8) and digits(2) and lowerCase(2) and upperCase(2) and specialChars(2) and notUsername()`](https://github.com/keycloak/keycloak/blob/6.0.1/testsuite/integration-arquillian/tests/base/src/test/java/org/keycloak/testsuite/policy/PasswordPolicyTest.java#L243)

The [policies provided with KeyCloak](https://www.keycloak.org/docs/6.0/server_admin/#password-policy-types) are:

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
| `passwordHistory(int)` | number of last used passwords to disallow | - |

On the realm model the password policy attribute is also used for other purposes.
There are some registered "policies", that do not actually implement a policy that
a password is checked against, but when it has to be changed and how it is stored.

If these currently work is completely untested.

| Identifier    | Description                          | Tested |
| ------------- |:------------------------------------ | ------ |
| `forceExpiredPasswordChange(int)` | number of days to expire password after | - |
| `hashAlgorithm(string)` | hash algorithm to use when hashing the password | - |
| `hashIterations(int)` | number of hash iterations | - |


## Implementation
To minimize code duplication the extension uses as much of the built-in KeyCloak code
as possible. The parsing and instantiation of the policy provider classes is used as-is.

As all policies are configured via the RealmModel, a custom implementation of the RealmModel
interface (`FakeRealm`) is used to inject the configuration into the classes.

For details please have a look at the source code.
