$ProjectDir = Get-Location
$AppDir = Join-Path $ProjectDir "app"
$RawDir = Join-Path $AppDir "src\main\res\raw"
$GSPath = Join-Path $ProjectDir "google-services.json"
$LottiePath = Join-Path $ProjectDir "lottie.json"
$KeystorePath = Join-Path $ProjectDir "release-keystore.jks"
if (Test-Path $GSPath) {
    Copy-Item $GSPath (Join-Path $AppDir "google-services.json") -Force
}
if (Test-Path $LottiePath) {
    if (-not (Test-Path $RawDir)) { New-Item -ItemType Directory -Path $RawDir -Force | Out-Null }
    Copy-Item $LottiePath (Join-Path $RawDir "animation.json") -Force
}
if (Test-Path $KeystorePath) {
    $bytes = [System.IO.File]::ReadAllBytes($KeystorePath)
    $b64 = [System.Convert]::ToBase64String($bytes)
    Set-Content -Path (Join-Path $ProjectDir "keystore.b64") -Value $b64 -NoNewline
}
