import { Component, OnInit } from '@angular/core';
import { Receita } from '../model/receita';
import { Router } from '@angular/router';
import { Ingrediente } from '../model/ingrediente';

@Component({
  selector: 'app-visualizar-receita',
  templateUrl: './visualizar-receita.component.html',
  styleUrls: ['./visualizar-receita.component.css']
})
export class VisualizarReceitaComponent implements OnInit {

  receita: Receita;
  ingredientes: Ingrediente[];

  constructor(private router: Router) { }

  ngOnInit() {
    const jsonReceita = window.sessionStorage.getItem('receita');

    this.receita = JSON.parse(jsonReceita);

    this.ingredientes = this.receita.tbingredienteCollection;
  }

  proximaPagina() {
    this.salvarReceitaLocal();

    this.router.navigate(['\concluir']);
  }

  salvarReceitaLocal() {
    const jsonAux = JSON.stringify(this.receita);

    window.sessionStorage.setItem('receita', jsonAux);
  }

}
