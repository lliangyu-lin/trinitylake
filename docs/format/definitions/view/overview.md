# Overview

A view is a virtual table whose contents are determined by a query. Similar to a table, 
a view consists of a structured set of named columns and dynamically generated rows.
However, unless explicitly materialized, a view does not store data itself. 
Instead, when queried, it retrieves data from underlying tables based on its defining query,
ensuring that the results remain up-to-date with the source data.

## Object Definition Schema

***Schema ID: 3***

| Field Name        | Protobuf Type              | Description                                                                                                     | Required? | Default  |
|-------------------|----------------------------|-----------------------------------------------------------------------------------------------------------------|-----------|----------|
| name              | string                     | A user-friendly name of this view                                                                               | Yes       |          |
| schema_binding    | boolean                    | If `true`, the view uses the schema defined at creation time; otherwise, it is evaluated dynamically            | Yes       | false    |
| schema            | Schema                     | Schema of the view, required if `schema_binding = true`                                                         | No        |          |
| representation    | repeated SQLRepresentation | Different SQL representations of the view, supporting multiple SQL dialects                                     | Yes       |          |
| view_type         | string                     | Type of the view (e.g., STANDARD, MATERIALIZED)                                                                 | No        | STANDARD |
| view_format       | string                     | The format of the view, which decides the usage of `format_properties`. Currently `ICEBERG` is the only option. | Yes       |          |
| format_properties | map<string, string>        | Free form format-specific key-value string properties, e.g. [Apache Iceberg](./iceberg.md)                      | No        |          |
| properties        | map<string, string>        | Free form user-defined key-value string properties                                                              | No        |          |

## Name Size

All view names must obey the maximum size configuration defined in the [Lakehouse definition file](../lakehouse.md).