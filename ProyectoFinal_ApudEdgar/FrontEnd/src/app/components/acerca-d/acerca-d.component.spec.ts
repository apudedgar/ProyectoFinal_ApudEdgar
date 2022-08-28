import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcercaDComponent } from './acerca-d.component';

describe('AcercaDComponent', () => {
  let component: AcercaDComponent;
  let fixture: ComponentFixture<AcercaDComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcercaDComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AcercaDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
