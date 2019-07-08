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

  constructor(private router: Router, private service: CadastrarIngredienteService) { }

  ngOnInit() {
    const jsonReceita = window.sessionStorage.getItem('receita');

    this.receita = JSON.parse(jsonReceita);
  }

  getIngredientes() {
    this.service.getIngredientes()
      .subscribe(dados => this.ingredientes = dados);
  }

  proximaPagina() {
    this.salvarReceitaLocal();

    this.router.navigate(['cadastrar-unidade-medida']);
  }

  salvarReceitaLocal() {
    const jsonAux = JSON.stringify(this.receita);

    window.sessionStorage.setItem('receita', jsonAux);
  }

  onSelect(id) {
    this.receita.tbingredienteCollection = this.service.getIngredientes().filter((item) => item.tbingredienteCollection === id);
  }
}
