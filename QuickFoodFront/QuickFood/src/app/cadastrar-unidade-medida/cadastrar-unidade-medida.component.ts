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

  constructor(private service: CadastrarUnidadeMedidaService, private router: Router) { }

  ngOnInit() {
    const jsonReceita = window.sessionStorage.getItem('receita');

    this.receita = JSON.parse(jsonReceita);
    this.ingredientes = this.receita.tbingredienteCollection;
  }

  salvarReceitaLocal() {
    const jsonAux = JSON.stringify(this.receita);

    window.sessionStorage.setItem('receita', jsonAux);
  }

  proximaPagina() {
    this.salvarReceitaLocal();

    this.router.navigate(['cadastrar-unidade-medida']);
  }

  onSelectIngredienteAtual(id) {
    this.receita.tbingredienteCollection = this.service.getUnidadeMedida().filter((item) => item.tbingredienteCollection === id);
  }

}
