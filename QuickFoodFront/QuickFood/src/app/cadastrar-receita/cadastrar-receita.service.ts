import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Config } from '../config/config';
import { config } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CadastrarReceitaService {

  constructor(private http: HttpClient) { }

  salvar(receita) {
    const url = `${Config.salvarReceita + receita}`;
    return this.http.get<Response>(`${url}`);
  }
}
