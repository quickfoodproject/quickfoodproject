import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModoPreparoComponent } from './modo-preparo.component';

describe('ModoPreparoComponent', () => {
  let component: ModoPreparoComponent;
  let fixture: ComponentFixture<ModoPreparoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModoPreparoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModoPreparoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
