import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

import { CourseCardComponent } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent {
  courses = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4 },
    { id: 2, name: 'Web Development', code: 'CS102', credits: 3 },
    { id: 3, name: 'Database Systems', code: 'CS103', credits: 4 },
    { id: 4, name: 'Operating Systems', code: 'CS104', credits: 3 },
    { id: 5, name: 'Software Engineering', code: 'CS105', credits: 2 }
  ];

  selectedCourseId: number | null = null;

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}