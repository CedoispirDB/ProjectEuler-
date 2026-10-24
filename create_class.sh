#!/bin/bash

name="$1"
numero="$2"

if [[ -z "${name}" ]]; then
    echo "Missing name"
    exit 1
fi

if [[ -z "${numero}" ]]; then
    echo "Missing problem number"
    exit 1
fi

path="./src/euler"

clean_name="${name// /}"

class_name="a${numero}${clean_name}"

file="${path}/${class_name}.java"

# Verifica se o arquivo ja existe
if [[ -e "${file}" ]]; then
    echo "Arquivo ${file} ja existe. Operacao cancelada."
    exit 1
fi

mkdir -p "${path}"

# Cria o arquivo sem sobrescrever um existente
if ! (set -C; cat > "${file}" <<EOF
package euler;

import java.util.*;
import utils.*;

public class ${class_name} {

    public static void main(String[] args) {

    }
}
EOF
); then
    echo "Erro ao criar ${file}."
    exit 1
fi

echo "Arquivo ${file} criado"
