# Authentication

HelloWorldExt uses **no authentication**. It does not call any external system, so there are no
credentials, tokens, or scopes to obtain or configure.

## Obtaining credentials

Not applicable — this extension has no connection fields and nothing to authenticate against.

## Required scopes / permissions

| Scope / Permission | Why it's needed |
|---|---|
| *(none)* | Not applicable — no external system is called. |

## Verifying

Run **Test Connection** in the SetUp area. It always succeeds, since it only confirms the extension
itself is loaded and reachable — there is no external connectivity to verify.
