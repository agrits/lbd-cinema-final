GLOBIGNORE="db.json"
filenames=*.json
echo "{" > db.json
for filename in $filenames; do
  content="$(cat $filename)"
  filename="${filename%.*}"
  echo "\"$filename\": $content," >> "db.json"
done
echo "}" >> db.json

unset GLOBIGNORE
