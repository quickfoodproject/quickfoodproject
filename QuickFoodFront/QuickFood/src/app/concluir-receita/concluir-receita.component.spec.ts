import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConcluirReceitaComponent } from './concluir-receita.component';

describe('ConcluirReceitaComponent', () => {
  let component: ConcluirReceitaComponent;
  let fixture: ComponentFixture<ConcluirReceitaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConcluirReceitaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConcluirReceitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
