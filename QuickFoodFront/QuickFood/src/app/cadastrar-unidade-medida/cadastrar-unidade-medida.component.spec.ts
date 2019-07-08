import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarUnidadeMedidaComponent } from './cadastrar-unidade-medida.component';

describe('CadastrarUnidadeMedidaComponent', () => {
  let component: CadastrarUnidadeMedidaComponent;
  let fixture: ComponentFixture<CadastrarUnidadeMedidaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadastrarUnidadeMedidaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastrarUnidadeMedidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
