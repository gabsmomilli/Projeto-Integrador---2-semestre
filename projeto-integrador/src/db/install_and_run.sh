docker build -t scrapping/postgres .
docker run -p 5432:5432 -d scrapping/postgres
echo "Banco de dados rodando com sucesso."