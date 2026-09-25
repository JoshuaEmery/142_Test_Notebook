#!/usr/bin/env bash
# Runs once when the codespace is created.
set -euo pipefail

echo "Installing Jupyter and the Java notebook kernel (JJava)..."
python3 -m pip install --user --upgrade pip
python3 -m pip install --user jupyter ipykernel "jjava==1.0a8"

echo "Available notebook kernels:"
python3 -m jupyter kernelspec list

echo "Warming up the Maven cache so the first test run is fast..."
mvn -q -B dependency:go-offline || true

echo "Setup complete."
