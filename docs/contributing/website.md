# Website

The TrinityLake project website is built using the 
[mkdocs-material](https://pypi.org/project/mkdocs-material/) framework with a few other plugins.

## Setup

The easiest way to setup website is to create a Python virtual environment
and install the necessary dependencies:

```bash
python3 -m venv env
source env/bin/activate
pip install mkdocs-material
pip install mkdocs-awesome-pages-plugin
```

## Serve website

You can serve the website by enabling the virtual environment and then run the `mkdocs` server:

```bash
source env/bin/activate
mkdocs serve
```

This will run the server at `http://localhost:8000`