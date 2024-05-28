package com.example.ticoteco.modelo;

public class Post {
    private int id;
    private String assunto;
    private String post;

    public Post() {}

    public Post(int id, String assunto, String post) {
        this.id = id;
        this.assunto = assunto;
        this.post = post;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAssunto() {return assunto;}
    public void setAssunto(String assunto) {this.assunto = assunto;}
    public String getPost() {return post;}
    public void setPost(String post) {this.post = post;}
}
