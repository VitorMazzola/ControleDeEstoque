package br.com.cast.turmaformacao.controledeestoque.controllers.controllers.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.cast.turmaformacao.controledeestoque.R;
import br.com.cast.turmaformacao.controledeestoque.controllers.controllers.asyncTask.ProdutoAsyncTaskSave;
import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.entities.Produto;
import br.com.cast.turmaformacao.controledeestoque.controllers.model.entities.services.ProdutoBusinessService;
import br.com.cast.turmaformacao.controledeestoque.controllers.util.FormHelper;

public class CadastroProdutoActivity extends AppCompatActivity{


    private EditText editTextNome;
    private EditText editTextDescricao;
    private EditText editTextQuantidade;
    private EditText editTextQuantidadeMinima;
    private EditText editTextValor;
    private Button buttonSalvar;
    private Produto produto;
    public static final String PARAM_TASK = "PARAM_TASK";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        initProduto();
        bindEditTextNome();
        bindEditTextDescricao();
        bindEditTextQuantidade();
        bindEditTextQuantidadeMinima();
        bindEditTextValor();
        bindButtonSalvar();
    }

    private void initProduto() {
        Bundle extras = getIntent().getExtras();

        if(extras != null){
            this.produto = (Produto) extras.getParcelable(PARAM_TASK);
        }

        this.produto = this.produto == null ? new Produto() : this.produto;
    }


    private void bindButtonSalvar() {
        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String requiredMessage = CadastroProdutoActivity.this.getString(R.string.msg_required);
                if (!FormHelper.validateRequired(requiredMessage, editTextNome)) {
                    bindProduto();
                    ProdutoBusinessService.save(produto);
                    Toast.makeText(CadastroProdutoActivity.this, getString(R.string.msg_save_sucessfull), Toast.LENGTH_LONG).show();
                    CadastroProdutoActivity.this.finish();
                }
            }
        });
    }


    private void bindProduto() {
        produto.setNome(editTextNome.getText().toString());
        produto.setDescricao(editTextDescricao.getText().toString());
        produto.setQuantidade(Long.parseLong(editTextQuantidade.getText().toString()));
        produto.setQuantidadeMinima(Long.parseLong(editTextQuantidadeMinima.getText().toString()));
        produto.setValor(Double.parseDouble(editTextValor.getText().toString()));

    }


    private void bindEditTextValor() {
        editTextValor = (EditText) findViewById(R.id.editTextValor);
        editTextValor.setText(produto.getValor() == null ? "" : produto.getValor().toString());
    }


    private void bindEditTextQuantidadeMinima() {
        editTextQuantidadeMinima = (EditText) findViewById(R.id.editTextQuantidadeMinima);
        editTextQuantidadeMinima.setText(produto.getQuantidadeMinima() == null ? "" : produto.getQuantidadeMinima().toString());
    }

    private void bindEditTextQuantidade() {
        editTextQuantidade = (EditText) findViewById(R.id.editTextQuantidade);
        editTextQuantidade.setText(produto.getQuantidade() == null ? "" : produto.getQuantidade().toString());
    }

    private void bindEditTextDescricao() {
        editTextDescricao = (EditText) findViewById(R.id.editTextDescricaoDoProduto);
        editTextDescricao.setText(produto.getDescricao() == null ? "" : produto.getDescricao());
    }

    private void bindEditTextNome() {
        editTextNome = (EditText) findViewById(R.id.editTextNomeProduto);
        editTextNome.setText(produto.getNome() == null ? "" : produto.getNome());
    }
}
