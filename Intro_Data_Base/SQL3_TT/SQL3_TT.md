# SQL 3 - MOVIES DB

## 1. Explique o conceito de normalização e para que é usado.

<span style="color:green"> Response: </span>
A normalizaçao tem a finaldade de padronização e validação do banco, para que se possa eliminar redundâncias e inconsistencias, na base da dados.

## 2. Adicione um filme à tabela de filmes.
```sql
INSERT INTO movies (title,rating,awards,release_date) VALUES ('Pulp Fiction',8.9,28,'1995-02-18');
```
<span style="color:green"> Response: </span>

| id | created_at | updated_at | title                                               | rating | awards | release_date        | length | genre_id |
|----|:------------|:------------|:-----------------------------------------------------|:--------|:--------|:---------------------|:--------|:----------:|
|  1 | NULL       | NULL       | Avatar                                              |    7.9 |      3 | 2010-10-04 00:00:00 |    120 |        5 |
|  2 | NULL       | NULL       | Titanic                                             |    7.7 |     11 | 1997-09-04 00:00:00 |    320 |        3 |
|  3 | NULL       | NULL       | La Guerra de las galaxias: Episodio VI              |    9.1 |      7 | 2004-07-04 00:00:00 |   NULL |        5 |
|  4 | NULL       | NULL       | La Guerra de las galaxias: Episodio VII             |    9.0 |      6 | 2003-11-04 00:00:00 |    180 |        5 |
|  5 | NULL       | NULL       | Parque Jurasico                                     |    8.3 |      5 | 1999-01-04 00:00:00 |    270 |        5 |
|  6 | NULL       | NULL       | Harry Potter y las Reliquias de la Muerte - Parte 2 |    9.0 |      2 | 2008-07-04 00:00:00 |    190 |        6 |
|  7 | NULL       | NULL       | Transformers: el lado oscuro de la luna             |    0.9 |      1 | 2005-07-04 00:00:00 |   NULL |        5 |
|  8 | NULL       | NULL       | Harry Potter y la piedra filosofal                  |   10.0 |      1 | 2008-04-04 00:00:00 |    120 |        8 |
|  9 | NULL       | NULL       | Harry Potter y la c�mara de los secretos            |    3.5 |      2 | 2009-08-04 00:00:00 |    200 |        8 |
| 10 | NULL       | NULL       | El rey le�n                                         |    9.1 |      3 | 2000-02-04 00:00:00 |   NULL |       10 |
| 11 | NULL       | NULL       | Alicia en el pa�s de las maravillas                 |    5.7 |      2 | 2008-07-04 00:00:00 |    120 |     NULL |
| 12 | NULL       | NULL       | Buscando a Nemo                                     |    8.3 |      2 | 2000-07-04 00:00:00 |    110 |        7 |
| 13 | NULL       | NULL       | Toy Story                                           |    6.1 |      0 | 2008-03-04 00:00:00 |    150 |        7 |
| 14 | NULL       | NULL       | Toy Story 2                                         |    3.2 |      2 | 2003-04-04 00:00:00 |    120 |        7 |
| 15 | NULL       | NULL       | La vida es bella                                    |    8.3 |      5 | 1994-10-04 00:00:00 |   NULL |        3 |
| 16 | NULL       | NULL       | Mi pobre angelito                                   |    3.2 |      1 | 1989-01-04 00:00:00 |    120 |        1 |
| 17 | NULL       | NULL       | Intensamente                                        |    9.0 |      2 | 2008-07-04 00:00:00 |    120 |        7 |
| 18 | NULL       | NULL       | Carrozas de fuego                                   |    9.9 |      7 | 1980-07-04 00:00:00 |    180 |     NULL |
| 19 | NULL       | NULL       | Big                                                 |    7.3 |      2 | 1988-02-04 00:00:00 |    130 |        8 |
| 20 | NULL       | NULL       | I am Sam                                            |    9.0 |      4 | 1999-03-04 00:00:00 |    130 |        3 |
| 21 | NULL       | NULL       | Hotel Transylvania                                  |    7.1 |      1 | 2012-05-04 00:00:00 |     90 |       10 |
| 22 | NULL       | NULL       | Pulp Fiction                                        |    8.9 |     28 | 1995-02-18 00:00:00 |   NULL |     NULL |

22 rows in set (0.00 sec)

## 3. Adicione um gênero à tabela de gêneros.
```sql
    INSERT INTO genres (name, ranking,active) VALUES ('Crime',13,1);
```

<span style="color:green"> Response: </span>

| id | created_at          | updated_at | name            | ranking | active |
|----|:---------------------|:------------|:-----------------|:---------|:--------:|
|  1 | 2016-07-04 03:00:00 | NULL       | Comedia         |       1 |      1 |
|  2 | 2014-07-04 03:00:00 | NULL       | Terror          |       2 |      1 |
|  3 | 2013-07-04 03:00:00 | NULL       | Drama           |       3 |      1 |
|  4 | 2011-07-04 03:00:00 | NULL       | Accion          |       4 |      1 |
|  5 | 2010-07-04 03:00:00 | NULL       | Ciencia Ficcion |       5 |      1 |
|  6 | 2013-07-04 03:00:00 | NULL       | Suspenso        |       6 |      1 |
|  7 | 2005-07-04 03:00:00 | NULL       | Animacion       |       7 |      1 |
|  8 | 2003-07-04 03:00:00 | NULL       | Aventuras       |       8 |      1 |
|  9 | 2008-07-04 03:00:00 | NULL       | Documental      |       9 |      1 |
| 10 | 2013-07-04 03:00:00 | NULL       | Infantiles      |      10 |      1 |
| 11 | 2011-07-04 03:00:00 | NULL       | Fantasia        |      11 |      1 |
| 12 | 2013-07-04 03:00:00 | NULL       | Musical         |      12 |      1 |
| 13 | NULL                | NULL       | Crime           |      13 |      1 |

13 rows in set (0.00 sec)

## 4. Associe o filme do Ex 2. ao gênero criado no Ex. 3.
```sql
UPDATE movies SET genre_id=13 WHERE movies.title = 'Pulp Fiction';
```
<span style="color:green"> Response: </span>
....

| id | created_at | updated_at | title                                               | rating | awards | release_date        | length | genre_id |
|----|:------------|:------------|:-----------------------------------------------------|:--------|:--------|:---------------------|:--------|:----------:|
| 16 | NULL       | NULL       | Mi pobre angelito                                   |    3.2 |      1 | 1989-01-04 00:00:00 |    120 |        1 |
| 17 | NULL       | NULL       | Intensamente                                        |    9.0 |      2 | 2008-07-04 00:00:00 |    120 |        7 |
| 18 | NULL       | NULL       | Carrozas de fuego                                   |    9.9 |      7 | 1980-07-04 00:00:00 |    180 |     NULL |
| 19 | NULL       | NULL       | Big                                                 |    7.3 |      2 | 1988-02-04 00:00:00 |    130 |        8 |
| 20 | NULL       | NULL       | I am Sam                                            |    9.0 |      4 | 1999-03-04 00:00:00 |    130 |        3 |
| 21 | NULL       | NULL       | Hotel Transylvania                                  |    7.1 |      1 | 2012-05-04 00:00:00 |     90 |       10 |
| 22 | NULL       | NULL       | Pulp Fiction                                        |    8.9 |     28 | 1995-02-18 00:00:00 |   NULL |       13 |

22 rows in set (0.00 sec)

## 5. Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2.
```sql
INSERT INTO actors (first_name,last_name,rating,favorite_movie_id) VALUES ('John','Travolta',5.1,22);
```

<span style="color:green"> Response: </span>

| id | created_at | updated_at | first_name | last_name           | rating | favorite_movie_id |
|----|:------------|:------------|:-------|:--------|:--------|:--------|:-----------|:----------:|
| 48 | NULL       | NULL       | Aaron      | Paul                |    5.9 |                 6 |
| 30 | NULL       | NULL       | Adam       | Sandler             |    3.1 |                 9 |
| 24 | NULL       | NULL       | Albert     | Brooks              |    2.5 |                 3 |
| 26 | NULL       | NULL       | Alexander  | Gould               |    7.5 |                 5 |
| 38 | NULL       | NULL       | Andrew     | Lincoln             |    3.3 |                17 |
| 49 | NULL       | NULL       | Anna       | Gunn                |    3.1 |                 7 |
|  6 | NULL       | NULL       | Billy      | Zane                |    7.5 |                 6 |
| 47 | NULL       | NULL       | Bryan      | Cranston            |    7.9 |              NULL |
|  9 | NULL       | NULL       | Carrie     | Fisher              |    7.5 |                 9 |
| 13 | NULL       | NULL       | Daniel     | Radcliffe           |    7.5 |                13 |
| 25 | NULL       | NULL       | Ellen      | DeGeneres           |    2.6 |                 4 |
| 32 | NULL       | NULL       | Emilia     | Clarke              |    8.2 |                11 |
| 14 | NULL       | NULL       | Emma       | Watson              |    2.5 |                14 |
|  8 | NULL       | NULL       | Harrison   | Ford                |    7.5 |                 8 |
| 22 | NULL       | NULL       | Helena     | Bonham Carter       |    7.5 |                 1 |
| 19 | NULL       | NULL       | James      | Earl Jones          |    7.5 |                19 |
| 35 | NULL       | NULL       | Jared      | Padalecki           |    2.8 |                14 |
| 12 | NULL       | NULL       | Jeff       | Goldblum            |    4.5 |              NULL |
| 36 | NULL       | NULL       | Jensen     | Ackles              |    5.5 |                15 |
| 20 | NULL       | NULL       | Jeremy     | Irons               |    7.2 |                20 |
| 45 | NULL       | NULL       | Jim        | Parsons             |    6.9 |                 3 |
| 41 | NULL       | NULL       | Jim        | Caviezel            |    1.9 |                20 |
| 37 | NULL       | NULL       | Jim        | Beaver              |    2.6 |                16 |
| 50 | NULL       | NULL       | John       | Travolta            |    5.1 |                22 |
| 21 | NULL       | NULL       | Johnny     | Depp                |    1.5 |                21 |
| 44 | NULL       | NULL       | Johnny     | Galecki             |    2.3 |                 2 |

...
50 rows in set (0.00 sec)

## 6. Crie uma cópia temporária da tabela de filmes.
```sql
CREATE TEMPORARY TABLE movies_aux SELECT * FROM movies;
```

## 7. Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.

```sql
DELETE FROM movies_aux WHERE movies_aux.awards < 5;
```

<span style="color:green"> Response: </span>

| id | created_at | updated_at | title                                   | rating | awards | release_date        | length | genre_id |
|----|:------------|:------------|:-------|:--------|:--------|:--------|:-----------|:----------:|
|  2 | NULL       | NULL       | Titanic                                 |    7.7 |     11 | 1997-09-04 00:00:00 |    320 |        3 |
|  3 | NULL       | NULL       | La Guerra de las galaxias: Episodio VI  |    9.1 |      7 | 2004-07-04 00:00:00 |   NULL |        5 |
|  4 | NULL       | NULL       | La Guerra de las galaxias: Episodio VII |    9.0 |      6 | 2003-11-04 00:00:00 |    180 |        5 |
|  5 | NULL       | NULL       | Parque Jurasico                         |    8.3 |      5 | 1999-01-04 00:00:00 |    270 |        5 |
| 15 | NULL       | NULL       | La vida es bella                        |    8.3 |      5 | 1994-10-04 00:00:00 |   NULL |        3 |
| 18 | NULL       | NULL       | Carrozas de fuego                       |    9.9 |      7 | 1980-07-04 00:00:00 |    180 |     NULL |
| 22 | NULL       | NULL       | Pulp Fiction                            |    8.9 |     28 | 1995-02-18 00:00:00 |   NULL |       13 |

7 rows in set (0.00 sec)

## 8. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.

```sql
SELECT g.name, COUNT(m.genre_id) AS n_movies FROM genres g INNER JOIN movies m ON (m.genre_id=g.id) GROUP BY m.genre_id HAVING n_movies >= 1;
```

<span style="color:green"> Response: </span>

| name            | n_movies |
|-----------------|:----------:|
| Comedia         |        1 |
| Drama           |        3 |
| Ciencia Ficcion |        5 |
| Suspenso        |        1 |
| Animacion       |        4 |
| Aventuras       |        3 |
| Infantiles      |        2 |
| Crime           |        1 |

8 rows in set (0.00 sec)

## 9. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios

```sql
SELECT a.first_name,a.last_name,m.awards FROM actors a INNER JOIN movies m ON(m.id = a.favorite_movie_id) WHERE m.awards > 3 ORDER BY m.awards; 
```

<span style="color:green"> Response: </span>

| first_name | last_name  | awards |
|---------|:--------|:----------:|
| Jeremy     | Irons      |      4 |
| Jim        | Caviezel   |      4 |
| Kate       | Winslet    |      5 |
| Alexander  | Gould      |      5 |
| Rupert     | Grint      |      5 |
| Jensen     | Ackles     |      5 |
| Leonardo   | Di Caprio  |      6 |
| Ellen      | DeGeneres  |      6 |
| Kaley      | Cuoco      |      6 |
| Albert     | Brooks     |      7 |
| Jim        | Parsons    |      7 |
| Matthew    | Broderick  |      7 |
| Zoe        | Saldana    |     11 |
| Mia        | Wasikowska |     11 |
| Johnny     | Galecki    |     11 |
| John       | Travolta   |     28 |

16 rows in set (0.00 sec)

## 10. Use o plano de explicação para analisar as consultas nos Ex. 9

```sql
EXPLAIN SELECT a.first_name,a.last_name,m.awards FROM actors a INNER JOIN movies m ON(m.id = a.favorite_movie_id) where m.awards > 3 order by m.awards;
```
<span style="color:green"> Response: </span>

| id | select_type | table | partitions | type | possible_keys                    | key                              | key_len | ref            | rows | filtered | Extra                       |
|----|:-------------|:-------|:------------|:------|:----------------------------------|:----------------------------------|:---------|:----------------|:------|:----------|:-----------------------------:|
|  1 | SIMPLE      | m     | NULL       | ALL  | PRIMARY                          | NULL                             | NULL    | NULL           |   22 |    33.33 | Using where; Using filesort |
|  1 | SIMPLE      | a     | NULL       | ref  | actors_favorite_movie_id_foreign | actors_favorite_movie_id_foreign | 5       | movies_db.m.id |    2 |   100.00 | NULL                        |

## 11. O que são os índices? Para que servem?

<span style="color:green"> Response: </span> Indices são mecanismos de consulta de bancos, servem para que possamos otimizar as consultas longas em um banco de dados.

## 12. Crie um índice sobre o nome na tabela de filmes.

```sql
CREATE INDEX title_idx ON movies(title)
```

## 13. Verifique se o índice foi criado corretamente.

```sql
SELECT * FROM movies USE INDEX (title_idx)
```

<span style="color:green"> Response: </span>

| id | created_at | updated_at | title                                               | rating | awards | release_date        | length | genre_id |
|----|:------------|:------------|:-------|:--------|:--------|:--------|:-----------|:----------:|
|  1 | NULL       | NULL       | Avatar                                              |    7.9 |      3 | 2010-10-04 00:00:00 |    120 |        5 |
|  2 | NULL       | NULL       | Titanic                                             |    7.7 |     11 | 1997-09-04 00:00:00 |    320 |        3 |
|  3 | NULL       | NULL       | La Guerra de las galaxias: Episodio VI              |    9.1 |      7 | 2004-07-04 00:00:00 |   NULL |        5 |
|  4 | NULL       | NULL       | La Guerra de las galaxias: Episodio VII             |    9.0 |      6 | 2003-11-04 00:00:00 |    180 |        5 |
|  5 | NULL       | NULL       | Parque Jurasico                                     |    8.3 |      5 | 1999-01-04 00:00:00 |    270 |        5 |
|  6 | NULL       | NULL       | Harry Potter y las Reliquias de la Muerte - Parte 2 |    9.0 |      2 | 2008-07-04 00:00:00 |    190 |        6 |
|  7 | NULL       | NULL       | Transformers: el lado oscuro de la luna             |    0.9 |      1 | 2005-07-04 00:00:00 |   NULL |        5 |
|  8 | NULL       | NULL       | Harry Potter y la piedra filosofal                  |   10.0 |      1 | 2008-04-04 00:00:00 |    120 |        8 |
|  9 | NULL       | NULL       | Harry Potter y la c�mara de los secretos            |    3.5 |      2 | 2009-08-04 00:00:00 |    200 |        8 |
| 10 | NULL       | NULL       | El rey le�n                                         |    9.1 |      3 | 2000-02-04 00:00:00 |   NULL |       10 |
| 11 | NULL       | NULL       | Alicia en el pa�s de las maravillas                 |    5.7 |      2 | 2008-07-04 00:00:00 |    120 |     NULL |
| 12 | NULL       | NULL       | Buscando a Nemo                                     |    8.3 |      2 | 2000-07-04 00:00:00 |    110 |        7 |
| 13 | NULL       | NULL       | Toy Story                                           |    6.1 |      0 | 2008-03-04 00:00:00 |    150 |        7 |
| 14 | NULL       | NULL       | Toy Story 2                                         |    3.2 |      2 | 2003-04-04 00:00:00 |    120 |        7 |
| 15 | NULL       | NULL       | La vida es bella                                    |    8.3 |      5 | 1994-10-04 00:00:00 |   NULL |        3 |
| 16 | NULL       | NULL       | Mi pobre angelito                                   |    3.2 |      1 | 1989-01-04 00:00:00 |    120 |        1 |
| 17 | NULL       | NULL       | Intensamente                                        |    9.0 |      2 | 2008-07-04 00:00:00 |    120 |        7 |
| 18 | NULL       | NULL       | Carrozas de fuego                                   |    9.9 |      7 | 1980-07-04 00:00:00 |    180 |     NULL |
| 19 | NULL       | NULL       | Big                                                 |    7.3 |      2 | 1988-02-04 00:00:00 |    130 |        8 |
| 20 | NULL       | NULL       | I am Sam                                            |    9.0 |      4 | 1999-03-04 00:00:00 |    130 |        3 |
| 21 | NULL       | NULL       | Hotel Transylvania                                  |    7.1 |      1 | 2012-05-04 00:00:00 |     90 |       10 |
| 22 | NULL       | NULL       | Pulp Fiction                                        |    8.9 |     28 | 1995-02-18 00:00:00 |   NULL |       13 |

22 rows in set (0.00 sec)

**OR**
```sql
SHOW INDEX FROM movies\G
```
<span style="color:green"> Response: </span>
```
*************************** 1. row ***************************
        Table: movies
   Non_unique: 0
     Key_name: PRIMARY
 Seq_in_index: 1
  Column_name: id
    Collation: A
  Cardinality: 21
     Sub_part: NULL
       Packed: NULL
         Null:
   Index_type: BTREE
      Comment:
Index_comment:
      Visible: YES
   Expression: NULL
*************************** 2. row ***************************
        Table: movies
   Non_unique: 1
     Key_name: movies_genre_id_foreign
 Seq_in_index: 1
  Column_name: genre_id
    Collation: A
  Cardinality: 8
     Sub_part: NULL
       Packed: NULL
         Null: YES
   Index_type: BTREE
      Comment:
Index_comment:
      Visible: YES
   Expression: NULL
*************************** 3. row ***************************
        Table: movies
   Non_unique: 1
     Key_name: title_idx
 Seq_in_index: 1
  Column_name: title
    Collation: A
  Cardinality: 22
     Sub_part: NULL
       Packed: NULL
         Null:
   Index_type: BTREE
      Comment:
Index_comment:
      Visible: YES
   Expression: NULL
*************************** 4. row ***************************
        Table: movies
   Non_unique: 1
     Key_name: title_idx2
 Seq_in_index: 1
  Column_name: title
    Collation: A
  Cardinality: 17
     Sub_part: 3
       Packed: NULL
         Null:
   Index_type: BTREE
      Comment:
Index_comment:
      Visible: YES
   Expression: NULL

4 rows in set (0.01 sec)
```
