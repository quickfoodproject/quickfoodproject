import { HttpHeaders } from '@angular/common/http';

const baseUrl = 'http://quickfood.cf/webresources/';
const httpOptions = {
    headers: new HttpHeaders ({'Content-Type': 'application/json'})
};
export class Config {
    static getAllIngredientes = baseUrl + 'ingrediente/getAll';
    static getAllUnidadeMedida = baseUrl + 'medida/getAll';
    static salvarReceita = baseUrl + 'receita/cadastrarReceita/';

    static getOptions() {
        return httpOptions;
    }

    static getHttpHeaders(): HttpHeaders {
        return new HttpHeaders()
            .set('Accept', 'application/json')
            .set('Content_Type', 'application/json');
    }

}
