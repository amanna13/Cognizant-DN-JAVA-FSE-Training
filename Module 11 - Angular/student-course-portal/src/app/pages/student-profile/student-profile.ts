import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

import { EnrollmentService } from '../../services/enrollment.service';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css'
})
export class StudentProfileComponent {
  constructor(private enrollmentService: EnrollmentService) {}

  get enrolledCourses() {
    return this.enrollmentService.getEnrolledCourses();
  }
}