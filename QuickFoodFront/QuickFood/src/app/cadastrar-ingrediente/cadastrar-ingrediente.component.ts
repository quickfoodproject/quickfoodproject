import { Component, OnInit } from '@angular/core';
import { Receita } from '../model/receita';
import { ActivatedRoute, Router } from '@angular/router';
import { Ingrediente } from '../model/ingrediente';
import { CadastrarIngredienteService } from './cadastrar-ingrediente.service';

@Component({
  selector: 'app-cadastrar-ingrediente',
  templateUrl: './cadastrar-ingrediente.component.html',
  styleUrls: ['./cadastrar-ingrediente.component.css']
})

export class CadastrarIngredienteComponent implements OnInit {

  receita: Receita;
  ingredientes: Ingrediente[];
  ingredientesSelecionado: Ingrediente[];

  constructor(private router: Router, private service: CadastrarIngredienteService) { }

  ngOnInit() {
    const jsonReceita = window.sessionStorage.getItem('receita');

    this.receita = JSON.parse(jsonReceita);

    this.getIngredientes();
  }

  getIngredientes() {
    this.service.getIngredientes()
      .subscribe(dados => this.ingredientes = dados);
  }

  salvarReceitaLocal() {
    this.receita.tbingredienteCollection = this.ingredientesSelecionado;
    const jsonAux = JSON.stringify(this.receita);

    window.sessionStorage.setItem('receita', jsonAux);
  }

  onSelect(id) {
    this.ingredientesSelecionado = this.ingredientes.filter((item) => item.bdID === id);
  }

  proximaPagina() {
    this.salvarReceitaLocal();

    this.router.navigate(['\cadastrar-unidade-medida']);
  }
}
