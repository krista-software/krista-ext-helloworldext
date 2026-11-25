# Health Check

## Overview
Reports the extension's JVM health. Since HelloWorldExt has no external system, this only reports
local heap usage.

## Request Details
- **Area**: SetUp
- **Type**: QUERY_SYSTEM
- **External API**: none — no outbound call is made

## Input Parameters
This request takes no inputs.

## Output Parameters
| Parameter | Type | Description |
|---|---|---|
| Is Healthy | Boolean | Always `true`. |
| Heap Used MB | Number | Current JVM heap usage, in megabytes. |
| Details | Text | A short status string including the invoker id, e.g. `OK (invoker <id>)`. |

## Example
**Input**: *(none)*
**Output**: `Is Healthy=true`, `Heap Used MB=42.0`, `Details=OK (invoker inv-123)`

## Error Handling
- There are no failure modes — there is no external connectivity to fail.
