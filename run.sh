#!/bin/bash

number="$1"

project_file=$(find src/euler -maxdepth 1 -type f -name "a${number}*.java" | head -n 1)

if [ -z "$project_file" ]; then
    echo "Projeto $number não encontrado."
    exit 1
fi

project_name=$(basename "$project_file" .java)

echo "Compilando $project_name..."

rm -rf src/out
mkdir -p src/out

javac -d src/out "$project_file" src/utils/*.java

if [ $? -ne 0 ]; then
    exit 1
fi

echo "Executando $project_name..."

java -cp src/out "euler.$project_name"