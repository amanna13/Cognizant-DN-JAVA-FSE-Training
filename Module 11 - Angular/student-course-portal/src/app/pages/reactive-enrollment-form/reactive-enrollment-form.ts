import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  ValidationErrors,
  Validators
} from '@angular/forms';

import { CanComponentDeactivate } from '../../guards/unsaved-changes.guard';

function noCourseCode(control: AbstractControl): ValidationErrors | null {
  const value = String(control.value ?? '');
  return value.startsWith('XX') ? { noCourseCode: true } : null;
}

function simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
  const value = String(control.value ?? '');

  return new Promise((resolve) => {
    setTimeout(() => {
      if (value.includes('test@')) {
        resolve({ emailTaken: true });
        return;
      }

      resolve(null);
    }, 800);
  });
}

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentFormComponent implements OnInit {
  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: this.fb.control('', [Validators.required, Validators.email], [simulateEmailCheck]),
      courseId: [null, [Validators.required, noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  onSubmit(): void {
    console.log(this.enrollForm.value);
    console.log(this.enrollForm.getRawValue());
  }

  canDeactivate(): boolean {
    return !this.enrollForm?.dirty || window.confirm('You have unsaved changes. Leave?');
  }

  addCourse(): void {
    this.additionalCourses.push(new FormControl('', { nonNullable: true, validators: Validators.required }));
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  get additionalCourses(): FormArray<FormControl<string>> {
    return this.enrollForm.get('additionalCourses') as FormArray<FormControl<string>>;
  }
}