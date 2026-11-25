# HelloWorldExt — Implementation Plan

## Summary
`HelloWorldExt` is a minimal, self-contained sample extension with a single read-only operation
that returns a "Hello, World!" greeting (optionally personalized with a `Name` input). It does not
call any external API — the response is generated locally inside the extension — so there is
nothing to authenticate against and no third-party system involved. This build exists to exercise
the extension-builder pipeline end to end, not to integrate a real vendor.

- **Extension name (slug):** `helloworldext`
- **Title:** HelloWorldExt
- **Version:** 1.0.0
- **Package:** `app.krista.extensions.zzztestsandbox.zzzdeleteme.helloworldext`
- **Ecosystem:** ZZZ Test Sandbox
- **Domain:** ZZZ Delete Me

## Area: Greeting

| Request | Inputs | Output | External endpoint | Reused or new |
|---|---|---|---|---|
| Get Hello World Greeting | `Name` (Text, optional) | `Message` (Text) | none — generated locally | New |

No `@Entity` is modeled — the greeting is a small ad-hoc result (a single message string), which
per the framework's field-types guidance is a scalar `Text` output, not a domain object.

## Authentication
**Pattern: NONE.** Per the user's explicit answer ("none"), this extension ships with no secured
connection fields and no Authentication tab requirement — consistent with there being no real
backend to authenticate against.

## Capabilities
| Capability | Enabled | Why |
|---|---|---|
| Entity search | No | No domain object/entity exists to search |
| Webhooks / WAIT_FOR_EVENT | No | No external system pushes events |
| MCP (`tool=true`) | No | Not requested; can be added later with a one-line change |
| Solutions tab | No | Not requested |
| File handling | No | No binary payloads involved |

## Domain reuse
`domain-catalog.json` reports `"found": false` for ZZZ Test Sandbox / ZZZ Delete Me — this
ecosystem/domain is brand new, so there is nothing published yet to reuse, modify, or avoid. The
one request above is built fresh, already named in a vendor-agnostic style ("Get Hello World
Greeting") consistent with how a future extension in this domain could reuse it.

## Placeholder IDs — must replace before deploy
Because the ecosystem/domain is new (no sibling extension exists to copy registered IDs from), the
following are minted as **stable placeholder UUIDs** so the code compiles, and **must be swapped for
the real Krista-registered values** before this extension can bind/deploy:

- `@Domain` `domainId`
- `ecosystemId`
- `ecosystemVersion`

These do not block compiling or testing the jar — only binding it into the real catalog.
