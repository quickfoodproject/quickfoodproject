import { Component, OnInit } from '@angular/core';
import { Receita } from '../model/receita';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from '../model/usuario';

@Component({
  selector: 'app-cadastrar-receita',
  templateUrl: './cadastrar-receita.component.html',
  styleUrls: ['./cadastrar-receita.component.css']
})
export class CadastrarReceitaComponent implements OnInit {

  receita: Receita;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
  }

}
