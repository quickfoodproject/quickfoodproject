import { HttpHeaders } from '@angular/common/http';

const baseUrl = "http://localhost:8080";

export class Config {
    static logarUrl = "usuario/logar";

    static getHttpHeders(): HttpHeaders {
        return new HttpHeaders()
            .set('Accept', 'application/json')
            .set('Content-type', 'application/json');
    }
}
