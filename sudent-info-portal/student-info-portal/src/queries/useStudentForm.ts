import { useMutation } from '@tanstack/react-query';
import Api from '../services/Api.ts';
import { StudentFormResponse, StudentFormValues } from '../scenes/student-creation/StudentFormTypes';

const useStudentForm = () => {
    return useMutation<StudentFormResponse, Error, StudentFormValues>(
        async (values: StudentFormValues) => {
            const response = await Api.post<StudentFormResponse>('v1/students', values);
            return response.data;
        },
    );
};

export default useStudentForm;
