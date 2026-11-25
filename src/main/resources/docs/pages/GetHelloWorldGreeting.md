# Get Hello World Greeting

## Overview
Returns a "Hello, World!" greeting. Pass a name to personalize it; omit it to get the generic
greeting.

## Request Details
- **Area**: Greeting
- **Type**: QUERY_SYSTEM
- **External API**: none — the greeting is generated locally, no outbound call is made

## Input Parameters
| Parameter | Type | Required | Description |
|---|---|---|---|
| Name | Text | No | Name to personalize the greeting with. Blank or omitted falls back to `World`. |

## Output Parameters
| Parameter | Type | Description |
|---|---|---|
| Message | Text | The greeting, e.g. `Hello, World!` or `Hello, Alex!`. |

## Example
**Input**: `Name=Alex`
**Output**: `Message=Hello, Alex!`

**Input**: *(Name omitted)*
**Output**: `Message=Hello, World!`

## Error Handling
- There are no failure modes — any input, including a blank or whitespace-only `Name`, falls back to
  the default greeting rather than failing.
