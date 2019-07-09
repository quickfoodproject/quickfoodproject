import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ingrediente } from '../model/ingrediente';
import { Config } from '../config/config';

@Injectable({
  providedIn: 'root'
})
export class CadastrarIngredienteService {

  constructor(private http: HttpClient) { }

  getIngredientes() {
    return this.http.get<Ingrediente[]>(`${Config.getAllIngredientes}`);
  }
}
