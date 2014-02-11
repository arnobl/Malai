for i in `find \`pwd\` -type f | grep .dot$`
do
	dot $i -Tsvg -O
done