param(
    [string]$name,
    [string]$numero
)

if ([string]::IsNullOrWhiteSpace($name)) {
    Write-Host "Missing name"
    exit 1
}

if ([string]::IsNullOrWhiteSpace($numero)) {
    Write-Host "Missing problem number"
    exit 1
}

$path = "./src/euler"

$clean_name = $name -replace '\s', ''

$class_name = "a${numero}${clean_name}"

$file = Join-Path $path "${class_name}.java"

New-Item -ItemType Directory -Path $path -Force | Out-Null

$class = @"
package euler;

import java.util.*;

public class ${class_name} {

    public static void main(String[] args) {

    }
}
"@

Set-Content -Path $file -Value $class -Encoding UTF8

Write-Host "Arquivo $file criado"
