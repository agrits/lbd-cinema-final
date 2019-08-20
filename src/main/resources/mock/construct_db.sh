GLOBIGNORE="db.json"
filenames=*.json
echo "{" > db.json
for filename in $filenames; do
  content="$(cat $filename)"
  filename="${filename%.*}"
  echo "\"$filename\": $content," >> "db.json"
done
echo -e "\r\b}" >> db.json

unset GLOBIGNORE
