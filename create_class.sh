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

touch "${file}"

echo "Arquivo ${file} criado"

class=$(cat << EOF
package euler;

import java.util.*;
import utils.*;

public class ${class_name} {

    public static void main(String[] args) {
    
    }
}
)

echo "${class}" >> ${file}