import { Component, OnInit } from '@angular/core';
import { Receita } from '../model/receita';
import { UnidadeMedida } from '../model/unidade-medida';
import { Ingrediente } from '../model/ingrediente';
import { CadastrarUnidadeMedidaService } from './cadastrar-unidade-medida.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastrar-unidade-medida',
  templateUrl: './cadastrar-unidade-medida.component.html',
  styleUrls: ['./cadastrar-unidade-medida.component.css']
})
export class CadastrarUnidadeMedidaComponent implements OnInit {

  receita: Receita;
  unidadeMedidas: UnidadeMedida[];
  ingredientes: Ingrediente[];
  ingredientesUnidadeMedida: Ingrediente[];

  constructor(private service: CadastrarUnidadeMedidaService, private router: Router) { }

  ngOnInit() {
    const jsonReceita = window.sessionStorage.getItem('receita');

    this.receita = JSON.parse(jsonReceita);
    this.ingredientes = this.receita.tbingredienteCollection;

    this.getAllUnidadeMedida();
  }

  salvarReceitaLocal() {
    this.receita.tbingredienteCollection = this.ingredientesUnidadeMedida;
    const jsonAux = JSON.stringify(this.receita);

    window.sessionStorage.setItem('receita', jsonAux);
  }

  proximaPagina() {
    this.salvarReceitaLocal();

    this.router.navigate(['\modo-preparo']);
  }

  onSelectIngredienteAtual(id) {
    this.ingredientesUnidadeMedida = this.ingredientes.filter((item) => item.bdID === id);
  }

  getAllUnidadeMedida() {
    this.service.getUnidadeMedida()
      .subscribe(dados => this.unidadeMedidas = dados);
  }

  adiconar(id: number, unidadeMedida: UnidadeMedida, qtd: Float64Array) {
    const ingredienteAtual = this.getIngredienteAtual(id);

    ingredienteAtual.bdQuantidade = qtd;
    ingredienteAtual.bdUnidadeMedida = unidadeMedida.bdID;

    this.ingredientesUnidadeMedida.push(ingredienteAtual);
  }

  getIngredienteAtual(id: number): Ingrediente {
// tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < this.ingredientes.length; ++i) {
      if (this.ingredientes[i].bdID === id) {
        return this.ingredientes[i];
      }
    }
  }

}
