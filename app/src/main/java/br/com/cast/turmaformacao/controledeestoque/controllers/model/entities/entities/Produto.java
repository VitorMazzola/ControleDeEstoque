package br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.entities;


import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable{

    private Long id;
    private String imagem;
    private String nome;
    private String descricao;
    private Long quantidade;
    private Long quantidadeMinima;
    private double valor;

    public Produto(){
        super();
    }

    public Produto(Parcel in){
        super();
        readFromParcel(in);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Long getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Long quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (Double.compare(produto.valor, valor) != 0) return false;
        if (id != null ? !id.equals(produto.id) : produto.id != null) return false;
        if (imagem != null ? !imagem.equals(produto.imagem) : produto.imagem != null) return false;
        if (nome != null ? !nome.equals(produto.nome) : produto.nome != null) return false;
        if (descricao != null ? !descricao.equals(produto.descricao) : produto.descricao != null)
            return false;
        if (quantidade != null ? !quantidade.equals(produto.quantidade) : produto.quantidade != null)
            return false;
        return !(quantidadeMinima != null ? !quantidadeMinima.equals(produto.quantidadeMinima) : produto.quantidadeMinima != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (imagem != null ? imagem.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        result = 31 * result + (quantidadeMinima != null ? quantidadeMinima.hashCode() : 0);
        temp = Double.doubleToLongBits(valor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", imagem='" + imagem + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", quantidadeMinima=" + quantidadeMinima +
                ", valor=" + valor +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.imagem);
        dest.writeString(this.nome);
        dest.writeString(this.descricao);
        dest.writeValue(this.quantidade);
        dest.writeValue(this.quantidadeMinima);
        dest.writeDouble(this.valor);
    }

    public void readFromParcel(Parcel in){
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.imagem = in.readString();
        this.nome = in.readString();
        this.descricao = in.readString();
        this.quantidade = (Long) in.readValue(Long.class.getClassLoader());
        this.quantidadeMinima = (Long) in.readValue(Long.class.getClassLoader());
        this.valor = in.readDouble();
    }
    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        public Produto createFromParcel(Parcel source) {
            return new Produto(source);
        }

        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };
}
