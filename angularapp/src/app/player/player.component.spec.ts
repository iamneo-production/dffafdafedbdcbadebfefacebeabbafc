import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PlayerComponent } from './player.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('PlayerComponent', () => {
  let component: PlayerComponent;
  let fixture: ComponentFixture<PlayerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormsModule, HttpClientModule, RouterTestingModule],

      declarations: [PlayerComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  fit('Week4_Day4_create_Player_component', () => {
    expect(component).toBeTruthy();
  });

  it('should emit editPlayerEvent when edit button is clicked', () => {
    const player = { id: 1, name: 'Player A', age: 25 };
    spyOn(component.editPlayerEvent, 'emit');

    component.onEditPlayer(player);

    expect(component.editPlayerEvent.emit).toHaveBeenCalledWith(player);
  });

  it('should emit deletePlayerEvent when delete button is clicked', () => {
    const playerId = 1;
    spyOn(component.deletePlayerEvent, 'emit');

    component.onDeletePlayer(playerId);

    expect(component.deletePlayerEvent.emit).toHaveBeenCalledWith(playerId);
  });

  // Add more test cases for onSaveEditedPlayerEvent, onCancelEditPlayerEvent, etc.
});
