# TrinityLake

***An Open Lakehouse Format for Big Data Analytics, ML & AI***

![TrinityLake Logo](https://github.com/trinitylake-io/trinitylake/blob/main/docs/logo/blue-text-horizontal.png?raw=true)

## Introduction

TrinityLake is an **Open Lakehouse Format** for Big Data Analytics, ML & AI.
It defines a storage layout on top of objects like
[Apache Iceberg](https://iceberg.apache.org/) tables,
[Substrait](https://substrait.io/) views, etc.
to form a complete storage-only lakehouse.

It offers the following key features:

- **Storage only** as a lakehouse solution that works exactly the same way locally, on premise and in the cloud
- **Multi-object multi-statement transactions** with standard SQL `BEGIN` and `COMMIT` semantics
- **Consistent time travel and snapshot export** across all objects in the lakehouse
- **Distributed transactions** for complicated write-audit-publish workflows to execute a transaction across multiple engines

For more details, please visit [trinitylake.io](https://trinitylake.io).