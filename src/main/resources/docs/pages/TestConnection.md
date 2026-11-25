# Test Connection

## Overview
Confirms the extension is reachable. Since HelloWorldExt has no external system, this always
succeeds — it proves the extension itself loaded correctly.

## Request Details
- **Area**: SetUp
- **Type**: QUERY_SYSTEM
- **External API**: none — no outbound call is made

## Input Parameters
This request takes no inputs.

## Output Parameters
| Parameter | Type | Description |
|---|---|---|
| Success | Boolean | Always `true`. |
| Message | Text | A confirmation message, e.g. `HelloWorldExt is reachable (no external system to connect to).` |

## Example
**Input**: *(none)*
**Output**: `Success=true`, `Message=HelloWorldExt is reachable (no external system to connect to).`

## Error Handling
- There are no failure modes — there is no external connectivity to fail.
