package com.aleilton.DesafioPureJS.model;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;

public class DAO {
  private String URI = "mongodb://192.168.1.76:27017";
  private String DB = "db_scc4_cadastro";
  private String COLLECTION = "cadastro";
  
  private MongoCollection<Document> connect() {
    MongoCollection<Document> collection = null;
    try {
      MongoClient client = MongoClients.create(URI);
      MongoDatabase database = client.getDatabase(DB);
      collection = database.getCollection(COLLECTION);
      return collection;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public ArrayList<Pessoa> findAll() {
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    try {
      MongoCollection<Document> collection = connect();
      FindIterable<Document> all = collection.find();
      all.forEach(pessoa -> {
        String id = pessoa.getObjectId("_id").toString();
        String nome = pessoa.getString("nome");
        String email = pessoa.getString("email");
        String telefone = pessoa.getString("telefone");
        String profissao = pessoa.getString("profissao");
        pessoas.add(new Pessoa(id, nome, email, telefone, profissao));
      });
      return pessoas;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public String insert(Pessoa pessoa) {
    try {
      MongoCollection<Document> collection = connect();
      InsertOneResult result = collection.insertOne(new Document()
          .parse(new Gson().toJson(pessoa)));
      return result.getInsertedId().asObjectId().getValue().toString();
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
  
  public void delete(String id) {
    try {
      MongoCollection<Document> collection = connect();
      collection.deleteOne(new Document("_id", new ObjectId(id)));
    } catch (Exception e) {
      System.out.println(e);
    }
  }
 
}
