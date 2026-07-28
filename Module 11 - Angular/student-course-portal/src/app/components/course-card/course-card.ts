import { CommonModule } from '@angular/common';
import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';

import { CreditLabelPipe } from '../../pipes/credit-label/credit-label.pipe';
import { EnrollmentService } from '../../services/enrollment.service';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course!: Course;

  isExpanded = false;

  constructor(
    private enrollmentService: EnrollmentService,
    private router: Router
  ) {}

  ngOnChanges(changes: SimpleChanges): void {
    const courseChange = changes['course'];

    if (courseChange) {
      console.log('Course input changed', {
        previousValue: courseChange.previousValue,
        currentValue: courseChange.currentValue
      });
    }
  }

  get cardClasses(): Record<string, boolean> {
    // A getter keeps the template binding compact while still centralising class logic.
    return {
      'card--enrolled': this.enrollmentService.isEnrolled(this.course.id),
      'card--full': this.course.credits >= 4,
      expanded: this.isExpanded
    };
  }

  get borderColor(): string {
    if (this.course?.gradeStatus === 'passed') {
      return 'green';
    }

    if (this.course?.gradeStatus === 'failed') {
      return 'red';
    }

    return 'grey';
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  navigateToCourse(): void {
    this.router.navigate(['courses', this.course.id]);
  }

  onEnrollClick(): void {
    if (this.enrollmentService.isEnrolled(this.course.id)) {
      this.enrollmentService.unenroll(this.course.id);
      return;
    }

    this.enrollmentService.enroll(this.course.id);
  }

  get enrollButtonLabel(): string {
    return this.enrollmentService.isEnrolled(this.course.id) ? 'Unenroll' : 'Enroll';
  }
}