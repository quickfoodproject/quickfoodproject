import { Component, OnInit } from '@angular/core';
import { Receita } from '../model/receita';
import { Ingrediente } from '../model/ingrediente';
import { Router } from '@angular/router';
import { CadastrarReceitaService } from '../cadastrar-receita/cadastrar-receita.service';

@Component({
  selector: 'app-concluir-receita',
  templateUrl: './concluir-receita.component.html',
  styleUrls: ['./concluir-receita.component.css']
})
export class ConcluirReceitaComponent implements OnInit {

  receita: Receita;
  ingredientes: Ingrediente[];

  constructor(private router: Router, private service: CadastrarReceitaService) { }

  ngOnInit() {
    const jsonReceita = window.sessionStorage.getItem('receita');

    this.receita = JSON.parse(jsonReceita);

    this.ingredientes = this.receita.tbingredienteCollection;
  }

  salvar() {
    const jsonReceita = JSON.stringify(this.receita);
    const jsonIngredientes = JSON.stringify(this.ingredientes);

    const receitaSalvar: string = jsonReceita + '\\' + jsonIngredientes;

    let response: Response;

    this.service.salvar(receitaSalvar).subscribe(dados => response = dados);

    const jsonAux = JSON.stringify(response);

    window.sessionStorage.setItem('response', jsonAux);

    this.router.navigate(['cadastar-receita']);
  }
}
