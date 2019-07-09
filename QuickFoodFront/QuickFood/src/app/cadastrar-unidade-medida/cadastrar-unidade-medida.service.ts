import { Injectable } from '@angular/core';
import { Receita } from '../model/receita';
import { HttpClient } from '@angular/common/http';
import { UnidadeMedida } from '../model/unidade-medida';
import { Config } from '../config/config';

@Injectable({
  providedIn: 'root'
})
export class CadastrarUnidadeMedidaService {

  constructor(private http: HttpClient) { }

  getUnidadeMedida() {
    return this.http.get<UnidadeMedida[]>(`${Config.getAllUnidadeMedida}`);
  }

}
