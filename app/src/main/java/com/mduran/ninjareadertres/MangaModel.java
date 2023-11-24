package com.mduran.ninjareadertres;

public class MangaModel {

    private String nombreManga;
    private int ratingCurso;
    private int imagenCurso;

    // Constructor
    public MangaModel(String nombreManga, int ratingCurso, int imagenCurso) {
        this.nombreManga = nombreManga;
        this.ratingCurso = ratingCurso;
        this.imagenCurso = imagenCurso;
    }

    // Getter and Setter
    public String getNombreManga() {
        return nombreManga;
    }

    public void setNombreManga(String nombreManga) {
        this.nombreManga = nombreManga;
    }

    public int getRatingCurso() {
        return ratingCurso;
    }

    public void setRatingCurso(int ratingCurso) {
        this.ratingCurso = ratingCurso;
    }

    public int getImagenCurso() {
        return imagenCurso;
    }

    public void setImagenCurso(int imagenCurso) {
        this.imagenCurso = imagenCurso;
    }
}