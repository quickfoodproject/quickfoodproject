import { TestBed } from '@angular/core/testing';

import { CadastrarUnidadeMedidaService } from './cadastrar-unidade-medida.service';

describe('CadastrarUnidadeMedidaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CadastrarUnidadeMedidaService = TestBed.get(CadastrarUnidadeMedidaService);
    expect(service).toBeTruthy();
  });
});
