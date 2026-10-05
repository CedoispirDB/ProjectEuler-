param(
    [Parameter(Mandatory = $true)]
    [string]$number
)

$projectFile = Get-ChildItem "src/euler" `
    -File `
    -Filter "a$number*.java" |
    Select-Object -First 1

if (-not $projectFile) {
    Write-Host "Projeto $number não encontrado."
    exit 1
}

$projectName = $projectFile.BaseName

Write-Host "Compilando $projectName..."

if (Test-Path "src/out") {
    Remove-Item "src/out" -Recurse -Force
}

New-Item -ItemType Directory -Path "src/out" | Out-Null

$utils = Get-ChildItem "src/utils/*.java" |
    ForEach-Object { $_.FullName }

javac -d "src/out" $projectFile.FullName $utils

if ($LASTEXITCODE -ne 0) {
    exit 1
}

Write-Host "Executando $projectName..."

java -cp "src/out" "euler.$projectName"