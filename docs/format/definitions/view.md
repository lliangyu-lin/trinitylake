# View

A view represents a transformation applied to a set of tables and views. 
It is commonly expressed as a SQL statement in various dialects.

## Object Definition Schema

***Schema ID: 3***

| Field Name          | Protobuf Type              | Description                                                                                             | Required? | Default  |
|---------------------|----------------------------|---------------------------------------------------------------------------------------------------------|-----------|----------|
| name                | string                     | A user-friendly name of this view                                                                       | Yes       |          |
| view_type           | string                     | Type of the view (e.g., `STANDARD`, `MATERIALIZED`)                                                     | No        | STANDARD |
| schema_binding      | boolean                    | If `true`, the view uses the schema defined at creation time; otherwise, it is evaluated dynamically    | Yes       | false    |
| schema              | Schema                     | Schema of the view, similar to [Table Schema](table-schema.md). Required if `schema_binding = true`     | No        |          |
| sql_representations | repeated SQLRepresentation | Different SQL representations of the view, supporting multiple SQL dialects                             | Yes       |          |
| referenced_objects  | repeated string            | List of base tables or views that this view references                                                  | No        |          |
| properties          | map<string, string>        | Free form user-defined key-value string properties                                                      | No        |          |

## Name Size

All view names must obey the maximum size configuration defined in the [Lakehouse definition file](../lakehouse.md).