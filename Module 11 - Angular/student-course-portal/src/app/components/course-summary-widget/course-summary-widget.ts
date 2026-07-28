import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-summary-widget',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-summary-widget.html',
  styleUrl: './course-summary-widget.css'
})
export class CourseSummaryWidgetComponent {
  constructor(private courseService: CourseService) {}

  get courseCount(): number {
    return this.courseService.getCourses().length;
  }

  addSampleCourse(): void {
    const nextId = this.courseService.getCourses().length + 1;

    this.courseService.addCourse({
      id: nextId,
      name: 'Cloud Computing',
      code: `CS${100 + nextId}`,
      credits: 3,
      gradeStatus: 'pending'
    });
  }
}