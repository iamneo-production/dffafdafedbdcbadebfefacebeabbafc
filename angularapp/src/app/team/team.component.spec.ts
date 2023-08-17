import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TeamComponent } from './team.component';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

describe('TeamComponent', () => {
  let component: TeamComponent;
  let fixture: ComponentFixture<TeamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormsModule, HttpClientModule, RouterTestingModule],
      declarations: [TeamComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  fit('Week4_Day4_create_Team_Component', () => {
    expect(component).toBeTruthy();
  });

  it('should emit editTeamEvent when edit button is clicked', () => {
    const team = { id: 1, name: 'Team A', maximumBudget: 100 };
    spyOn(component.editTeamEvent, 'emit');

    component.onEditTeam(team);

    expect(component.editTeamEvent.emit).toHaveBeenCalledWith(team);
  });

  it('Week4_Day4_should emit deleteTeamEvent when delete button is clicked', () => {
    const teamId = 1;
    spyOn(component.deleteTeamEvent, 'emit');

    component.onDeleteTeam(teamId);

    expect(component.deleteTeamEvent.emit).toHaveBeenCalledWith(teamId);
  });



  // Add more test cases for saveEditedTeamEvent, cancelEditTeamEvent, etc.
});
